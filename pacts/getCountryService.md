# getCountryService

| Description    | Value |
| -------------- | ----- |
| Date Generated | Thu Jan 17 20:53:50 IST 2019 |
| Pact Version   | 3.6.1 |

## Verifying a pact between _getCountryServiceClient_ and _getCountryService_

Given **There is a country with alpha2_code as IN having name as India**  
A request for alpha2_code IN  
&nbsp;&nbsp;returns a response which  
&nbsp;&nbsp;&nbsp;&nbsp;has status code **200** (<span style='color:green'>OK</span>)  
&nbsp;&nbsp;&nbsp;&nbsp;includes headers  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"**Content-Type**" with value "**application/json**" (<span style='color:green'>OK</span>)  
&nbsp;&nbsp;&nbsp;&nbsp;has a matching body (<span style='color:green'>OK</span>)  
