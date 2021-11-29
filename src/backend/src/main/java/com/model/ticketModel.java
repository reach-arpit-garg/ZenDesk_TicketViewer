package com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ticketModel{
    public int id; 
    public String description;
    //public String url;
    //public String external_id;
    public String priority;
    public String subject;
    public String type;
    public String status;
    public int value;
    // public ArrayList<ArrayList<String>> via;
    // public ArrayList<String>  tickets;
    // public ArrayList<String> follower_ids;
    // public ArrayList<String> email_cc_ids;
    // public String forum_topic_id;
    // public String problem_id;
    // public String has_incidents;
    // public String is_public;
    // public String due_at;
    // public ArrayList<String> tags;
    // public ArrayList<String> custom_fields;
    // public String satisfaction_rating;
    // public ArrayList<String> sharing_agreement_ids;
    // public ArrayList<String> fields;
    // public ArrayList<String> followup_ids;
    // public String ticket_form_id;
    // public String brand_id;
    // public String allow_channelback;
    // public String allow_attachments;

    public String getId(){
        return Integer.toString(id);
    }

    public String getDescription(){
        return description;
    }

    public String getPriority(){
        return priority;
    }

    public String getSubject(){
        return subject;
    }

    public String getType(){
        return type;
    }

    public String getStatus(){
        return status;
    }
    }