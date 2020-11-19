package es.abelfgdeveloper.petclinic.customers.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.abelfgdeveloper.petclinic.customers.model.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public abstract class CommonApiTest {

  @Autowired private ObjectMapper objectMapper;

  @Autowired protected MockMvc mvc;

  @Autowired protected OwnerRepository ownerRepository;

  protected void cleanDataBase() {
    ownerRepository.deleteAll();
  }

  protected <T> T convertJsonAsStringToObject(String jsonAsString, Class<T> valueType)
      throws Exception {
    return objectMapper.readValue(jsonAsString, valueType);
  }

  protected String convertObjectToJsonAsString(Object content) throws Exception {
    return objectMapper.writeValueAsString(content);
  }
}
