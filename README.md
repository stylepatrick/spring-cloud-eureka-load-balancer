# spring-cloud-eureka-load-balancer

The project consists of:

- **an eureka-discovery-service (multiple replicas are possible) -> 8761**
- **feign-client -> 8080**
- **cloud-gateway -> 8282**
- **gateway-client -> 8081**
- **two servers (provides the same API) -> 71, 72**

Everything is secured by basic auth with spring-security.

The feign-client contacts one of the two servers via the eureka-discovery-service, depending on the ribbon load balancer. 
If one request fails (server goes offline, etc.), spring-retry will contact the next one. Client will not see any fail response.

A cloud-gateway and gateway-client is available to demonstrate how the load balancing could work, without having a feign-client.
The gateway-client does not need to part of the eureka-discovery-service and should simulate an external client, who access the servers over the cloud-gateway. 
Also here spring-retry is used to contact the next server if the first request fails.

Actuator endpoint /info and /health is open, metrics are secured by spring-security.