package com.vanavil.monitorresourcesapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "monitor-logs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitorLog {
    @Id
    private String monitorLogId;
    private String website;
    /*The availability status of the monitor.*/
    /*ID	Status
0	Down
1	Up
2	Trouble
3	Critical
5	Suspended
7	Maintenance
9	Discovery
10	Configuration Error*/
    private boolean availability;
    private Date collectionDateTime;
    /*The time taken for a TCP connection to be established with the server.*/
    private long connectionTime;
    /*The time taken to resolve the given domain name.*/
    private long dnsTime;
    /*The time taken for an SSL handshake with the server.*/
    private long sslTime;
    /*The total time taken by a web server to send the first response to the browser. It is the sum of TCP connection time, DNS time and SSL handshake time.*/
    private long responseTime;
    /*HTTP status code received from the server in response to the client’s request.*/
    private int responseCode;
    /*The length of the content obtained from the server’s response.*/
    private long contentLength;
    /*The global location from which monitoring is done.*/
    private String locationId;
    /*The authoritative name server IP used for monitoring.*/
    private String nameserver;
    /*The resolved IP which is used for monitoring.*/
    private String resolvedIP;
    /*The reason for the Down or Trouble status of the monitor.*/
    private String reason;
    /*The type of data collection*/
    /*ID	Type
1	Normal
2	Secondary Recheck
3	Poll Now
4	Screenshot
5	Hourly Poll
6	Uptime Steroid
7	Up Screenshot
8	Retry
9	Down Recheck
10	Other ISP*/
    private String dataCollectionType;
    
    /*
     Attribute	Type	Description
connection_time	string	The time taken for a TCP connection to be established with the server.
dns_time	string	The time taken to resolve the given domain name.
ssl_time	string	The time taken for an SSL handshake with the server.
response_code	string	HTTP status code received from the server in response to the client’s request.
collection_time	string	Time stamp at which the resource was collected for monitoring.
availability	string	The availability status of the monitor.
response_time	string	The total time taken by a web server to send the first response to the browser. It is the sum of TCP connection time, DNS time and SSL handshake time.
location_id	string	The global location from which monitoring is done.
nameserver	string	The authoritative name server IP used for monitoring.
resolved_ip	string	The resolved IP which is used for monitoring.
reason	string	The reason for the Down or Trouble status of the monitor.
content_length	string	The length of the content obtained from the server’s response.
data_collection_type	string	The type of data collection
*/
}