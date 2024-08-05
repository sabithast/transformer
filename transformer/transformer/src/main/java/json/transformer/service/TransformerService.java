package json.transformer.service;

import com.google.gson.*;
import json.transformer.entity.Block;
import json.transformer.entity.Floor;
import json.transformer.entity.Units;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransformerService {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<Block> transformJson(InputStream inputFilePath, String outputFilePath) throws IOException {
        JsonArray unitsArray = gson.fromJson(new InputStreamReader(inputFilePath), JsonArray.class);
        Map<Long, Map<Long, List<Units>>> blockMap = new HashMap<>();

        for (JsonElement unitElement : unitsArray) {
            JsonObject unitObject = unitElement.getAsJsonObject();
            Units unit = gson.fromJson(unitObject, Units.class);

            Long blockNumber = 1L;
            Long floorNumber = 1L;

            // Determine blockNumber and floorNumber from your JSON structure
            if (unitObject.has("blocknumber")) {
                blockNumber = unitObject.get("blocknumber").getAsLong();
            }
            if (unitObject.has("floornumber")) {
                floorNumber = unitObject.get("floornumber").getAsLong();
            }

            Map<Long, List<Units>> floorMap = blockMap.computeIfAbsent(blockNumber, k -> new HashMap<>());
            List<Units> unitsList = floorMap.computeIfAbsent(floorNumber, k -> new ArrayList<>());

            unitsList.add(unit);
        }

        List<Block> blocks = new ArrayList<>();
        for (Map.Entry<Long, Map<Long, List<Units>>> blockEntry : blockMap.entrySet()) {
            Block block = new Block();
            block.setBlocknumber(blockEntry.getKey());

            List<Floor> floors = new ArrayList<>();
            for (Map.Entry<Long, List<Units>> floorEntry : blockEntry.getValue().entrySet()) {
                Floor floor = new Floor();
                floor.setFloornumber(floorEntry.getKey());
                floor.setUnits(floorEntry.getValue());
                floors.add(floor);
            }

            block.setFloors(floors);
            blocks.add(block);
        }

        try (FileWriter writer = new FileWriter(outputFilePath)) {
            gson.toJson(blocks, writer);
        }

        return blocks;
    }
}
