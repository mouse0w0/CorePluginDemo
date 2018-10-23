package com.github.mouse0w0.coreplugindemo;

import spigotlauncher.api.ClassDefiner;
import spigotlauncher.api.plugin.CorePlugin;
import spigotlauncher.api.plugin.Transformer;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DemoCorePlugin implements CorePlugin {

    @Override
    public void initialize(ClassDefiner classDefiner) {

    }

    @Override
    public void acceptOptions(List<String> list, Path path) {

    }

    @Override
    public Collection<Transformer> getTransformers() {
        List<Transformer> transformers = new ArrayList<>();
        transformers.add(new HelloWorldTransformer());
        return transformers;
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[0];
    }
}
