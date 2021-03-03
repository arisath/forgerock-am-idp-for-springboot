package aris.ath.springsec.Client;

import aris.ath.springsec.Model.AuthResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class AMClient
{
    //@Value("${openAMEndpoint}")
    static String amUrl = "http://localhost:8081/openam/json/realms/root/sessions?_action=validate";

    public boolean validate(String ssotoken)
    {
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(amUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept-API-Version", "resource=2.1, protocol=1.0");
        headers.set("iPlanetDirectoryPro", ssotoken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);


        AuthResponse result = restTemplate.postForObject(amUrl, request, AuthResponse.class);
        return result.isValid();
    }

}
