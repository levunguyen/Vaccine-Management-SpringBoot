package com.project.payload.reponse;

import com.project.dto.PatientDTO;
import com.project.entity.Patient;

import java.util.List;


public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private Integer id;
    private String username;
    private List<String> roles;
    private Patient patient;

    public JwtResponse(String accessToken, Integer id, String username, List<String> roles, Patient patient) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.patient = patient;
    }

    public JwtResponse() {
    }



    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
