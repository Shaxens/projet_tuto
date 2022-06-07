package fr.tradflex.model;

import java.io.Serializable;

public record ProjectWhenCreating(String name, String description, String picture) implements Serializable {}