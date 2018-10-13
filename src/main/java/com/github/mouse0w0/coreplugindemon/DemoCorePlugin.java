package com.github.mouse0w0.coreplugindemon;

import spigotlauncher.api.CorePlugin;
import spigotlauncher.api.Transformer;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DemoCorePlugin implements CorePlugin {
    @Override
    public void acceptOptions(List<String> list, Path path) {

    }

    @Override
    public Collection<Transformer> getTransformers() {
        List<Transformer> transformers = new ArrayList<>();
        transformers.add(new HelloWorldTransformer());
        return transformers;
    }
}
