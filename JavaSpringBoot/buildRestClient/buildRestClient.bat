java -jar swagger-codegen-cli-2.4.19.jar generate -i http://localhost:8082/v2/api-docs --api-package com.te.accademy.webapi.client.api --model-package com.te.accademy.webapi.client.model --invoker-package  com.te.accademy.webapi.client.invoker --group-id  com.te.accademy --artifact-id webapi-restclient-codegen  --artifact-version 0.0.1-SNAPSHOT  -l java --library resttemplate -c config.json -o ../restapi 