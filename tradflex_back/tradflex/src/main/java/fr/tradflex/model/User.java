package fr.tradflex.model;

import java.io.Serializable;

public record User(String id, String pseudo) implements Serializable {}
