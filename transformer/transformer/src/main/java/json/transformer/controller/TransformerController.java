package json.transformer.controller;

import json.transformer.entity.Block;
import json.transformer.service.TransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class TransformerController {

    @Autowired
    private TransformerService transformService;

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/transform")
    public List<Block> transformJson() throws IOException {
        String inputFilePath = "unitjson.json";
        String outputFilePath = "blockfloorunit.json";
        InputStream inputStream = resourceLoader.getResource("classpath:" + inputFilePath).getInputStream();
        return transformService.transformJson(inputStream, outputFilePath);
    }
}
