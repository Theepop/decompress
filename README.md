# decompress
decompress test back end

method -> POST
url api -> /decompress/ 
  ex:http://127.0.0.1:8080/decompress/
Request ex:
  JSON body -> { "input":"2[c3[a]kb]" }
  
Response ex:
  { "result": "caaakbcaaakb" }

