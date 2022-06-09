package fr.tradflex.model.project;

import java.io.Serializable;

public record ProjectWhenCreating(String name, String description, String picture) implements Serializable {}