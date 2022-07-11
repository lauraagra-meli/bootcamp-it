package com.dh.meli.spring02.repository;

import com.dh.meli.spring02.model.Owner;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class OwnerRepo {
    ObjectMapper mapper = new ObjectMapper();
    List<Owner> list = null;

    try {
        list = Arrays.asList(mapper.readValue(new File(linkFile), Owner[].class));
    } catch (Exception e) {

    }
}
