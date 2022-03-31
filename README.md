# spring-cloud-eureka-load-balancer

The project consists of a eureka-discovery-service (multiple replicas are possible), a client and two servers. 
Everything is secured by basic auth with spring-security.
Both servers provide the same API endpoint.

The client contacts one of the two servers via the eureka-discovery-service, depending on the ribbon load balancer. 
If one request fails (server goes offline, etc.), spring-retry will contact the next one. Client will not see any fail response.

Actuator endpoint /info and /health is open, metrics are secured by spring-security.


