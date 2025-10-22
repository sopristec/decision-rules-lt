import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class DecisionRules extends Simulation {

  val httpProtocol = http
    .baseUrl("https://ssa-dr-api-dev.sopris-operations.com")
    .acceptHeader("application/json")
    .contentTypeHeader("application/json")

  val token = sys.env.getOrElse("DR_API_TOKEN",
    throw new RuntimeException("Environment variable DR_API_TOKEN not set")
  )

  val headers = Map(
    "Authorization" -> s"Bearer $token"
  )

  val requestBody =
    """
    {
    "data": {
        "event": {
            "prodState": "Production",
            "firstTime": 1759647724.859,
            "facility": null,
            "eventClassKey": null,
            "agent": "zenping",
            "dedupid": "201.154.29.224||/Status/Ping|5|201.154.29.224 is DOWN!",
            "Location": [
                {
                    "uid": "/zport/dmd/Locations/Uninet/chs-takana",
                    "name": "/Uninet/chs-takana"
                }
            ],
            "ownerid": null,
            "eventClass": {
                "text": "/Status/Ping",
                "uid": "/zport/dmd/Events/Status/Ping"
            },
            "id": "0242ac11-001b-ba28-11f0-a1b935319996",
            "DevicePriority": "Normal",
            "monitor": "connect-uninet",
            "priority": "ALTO",
            "details": {
                "status": "",
                "zenoss.device.location": "/Uninet/chs-takana",
                "zenoss.device.priority": "3",
                "zenoss.device.device_class": "/Network/Cisco/2800",
                "component": "IM-TEST",
                "manager": "85802fa5570a",
                "zenoss.device.production_state": "1000",
                "IM": "IM-TEST",
                "isManageIp": "True",
                "zenoss.device.ip_address": "201.154.29.224",
                "cNodeDown": false
            },
            "DeviceClass": [
                {
                    "uid": "/zport/dmd/Devices/Network/Cisco/2800",
                    "name": "/Network/Cisco/2800"
                }
            ],
            "eventKey": "",
            "evid": "0242ac11-001b-ba28-11f0-a1b935319996",
            "eventClassMapping": "",
            "component": {
                "url": null,
                "text": null,
                "uid": null,
                "uuid": null
            },
            "clearid": null,
            "DeviceGroups": [],
            "eventGroup": "Ping",
            "device": {
                "url": "/zport/dmd/goto?guid=0f0a3341-081b-4f3a-8f9e-6a621479b75a",
                "text": "ipsla-chs-takana-6.mer",
                "uuid": "0f0a3341-081b-4f3a-8f9e-6a621479b75a",
                "uid": "/zport/dmd/Devices/Network/Cisco/2800/devices/201.154.29.224"
            },
            "message": "201.154.29.224 is DOWN!",
            "severity": 5,
            "count": 17954,
            "stateChange": 1759647724.859,
            "ntevid": null,
            "summary": "201.154.29.224 is DOWN!",
            "eventState": "New",
            "lastTime": 1760727610.24,
            "ipAddress": [
                "201.154.29.224"
            ],
            "Systems": [],
            "collection_zone": "cz0",
            "event_device": "ipsla-chs-takana-6.mer",
            "cp_company": "UNINET",
            "event_class": "/Status/Ping",
            "device_name": "ipsla-chs-takana-6.mer",
            "first_time": "2025-10-05 01:02:04",
            "last_time": "2025-10-17 13:00:10",
            "cp_item": "",
            "cp_impact": 0,
            "minutes_open": 17998.089683334034,
            "location": "Uninetchs-takana",
            "event_key": "",
            "event_state": "New",
            "prod_state": "Production",
            "IM": "IM-TEST",
            "has_IM": true,
            "component_name": null,
            "device_class": "/Network/Cisco/2800",
            "prefix_to_store": "ipsla-chs-takana-6.mer",
            "incident_status": null,
            "cp_name": "",
            "node_oscilation": null,
            "active_maintenance_window": null,
            "events_to_validate_work_in_progress": {
                "count": 17954,
                "firstTime": 1759647724.859,
                "severity": 5,
                "evid": "0242ac11-001b-ba28-11f0-a1b935319996",
                "eventClassKey": null,
                "component": {
                    "url": null,
                    "text": null,
                    "uid": null,
                    "uuid": null
                },
                "summary": "201.154.29.224 is DOWN!",
                "IM": [
                    "IM-TEST"
                ],
                "eventState": "New",
                "device": {
                    "url": "/zport/dmd/goto?guid=0f0a3341-081b-4f3a-8f9e-6a621479b75a",
                    "text": "ipsla-chs-takana-6.mer",
                    "uuid": "0f0a3341-081b-4f3a-8f9e-6a621479b75a",
                    "uid": "/zport/dmd/Devices/Network/Cisco/2800/devices/201.154.29.224"
                },
                "message": "201.154.29.224 is DOWN!",
                "lastTime": 1760727610.24,
                "eventClass": {
                    "text": "/Status/Ping",
                    "uid": "/zport/dmd/Events/Status/Ping"
                },
                "details": {
                    "status": [
                        ""
                    ],
                    "zenoss.device.location": [
                        "/Uninet/chs-takana"
                    ],
                    "zenoss.device.priority": [
                        "3"
                    ],
                    "zenoss.device.device_class": [
                        "/Network/Cisco/2800"
                    ],
                    "component": [
                        "IM-TEST"
                    ],
                    "manager": [
                        "85802fa5570a"
                    ],
                    "zenoss.device.production_state": [
                        "1000"
                    ],
                    "IM": [
                        "IM-TEST"
                    ],
                    "isManageIp": [
                        "True"
                    ],
                    "zenoss.device.ip_address": [
                        "201.154.29.224"
                    ]
                }
            },
            "has_duplicates": false,
            "is_from_massive_fail": false,
            "minute_diff_last_massive_fail": 10,
            "last_massive_fail_event_has_IM": false,
            "related_events": {
                "evid": [],
                "device_name": [],
                "is_down": [],
                "is_sysup": [],
                "IM": [],
                "incident_status": []
            },
            "is_HA": false
        }
    }
}
    """

  // Scenario definition
  val scn = scenario("POST /composition/solve")
    .exec(
      http("POST Solve")
        .post("/composition/solve/ff1acd9a-e53d-722c-dd81-1d37dd412db5/1")
        .headers(headers)
        .body(StringBody(requestBody)).asJson
        .check(status.is(200)) // Expect HTTP 200 OK
    )

  // Load configuration
  setUp(
    scn.inject(
      rampUsers(10).during(10.seconds) // 10 users ramping up over 10s
    )
  ).protocols(httpProtocol)
}
