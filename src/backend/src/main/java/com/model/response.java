package com.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class response {
    public List<ticketModel> tickets;
    public ticketModel ticket;
}

