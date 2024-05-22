package com.vanavil.monitorresourcesapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "monitor")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Monitor {
    @Id
    private String monitorId;
    private boolean availability;
    // private String type;
    private String website;
    // private String check_frequency;
    // private int timeout;
    // private String location_profile_id;
    // private String notification_profile_id;
    // private String threshold_profile_id;
    // private String user_group_ids;
    // private String on_call_schedule_id;
    // private String http_method;
    // private int ip_type;
    // private int primary_protocol;
    // private int secondary_protocol_severity;
    // private String request_content_type;
    // private String request_param;
    // private String auth_method;
    // private String credential_profile_id;
    // private String oauth2_provider;
    // private String client_certificate_password;
    // private String jwt_id;
    // private String ssl_protocol;
    // private String http_protocol;
    // private boolean use_alpn;
    // private String matching_keyword;
    // private String unmatching_keyword;
    // private String match_regex;
    // private boolean match_case;
    // private String response_headers_check;
    // private String user_agent;
    // private String custom_headers;
    // private String monitor_groups;
    // private String dependency_resource_ids;
    // private String action_ids;
    // private boolean use_name_server;
    // private String forced_ips;
    // private String up_status_codes;
    // private boolean follow_redirect;
    // private boolean ignore_cert_err;
    // private String third_party_services;
    // private String tag_ids;
    // private boolean deep_discovery;
}
