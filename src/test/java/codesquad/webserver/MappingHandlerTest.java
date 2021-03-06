package codesquad.webserver;

import codesquad.Controller;
import codesquad.model.request.HttpRequest;
import codesquad.model.responses.*;
import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import static codesquad.model.HttpRequestTest.TEST_DIRECTORY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class MappingHandlerTest {
    private static final Logger log = getLogger(MappingHandlerTest.class);
    private HttpRequest httpRequest;
    private static Map<ResponseCode, ResponseTemplate> templates = Maps.newHashMap();

    static {
        templates.put(ResponseCode.OK, new ResponseTemplate200());
        templates.put(ResponseCode.FOUND, new ResponseTemplate300());
    }

    @Before
    public void setUp() throws Exception {
        InputStream in = new FileInputStream(new File(TEST_DIRECTORY + "Http_POST.txt"));
        httpRequest = new HttpRequest(in);
    }

    @Test
    public void reflectionTest() {
        Reflections reflections = new Reflections("codesquad");
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Controller.class);
        for (Class<?> aClass : annotated) {
            log.debug(aClass.getName());
        }
    }

    @Test
    public void redirect() {
        Object result = "redirect:/index.html";
        httpRequest.generateResponseCode(result);
        HttpResponse httpResponse = httpRequest.toResponse();
        ResponseTemplate responseTemplate = httpResponse.chooseTemplate(templates);
        assertThat(responseTemplate instanceof ResponseTemplate300).isTrue();
    }

    @Test
    public void ok() {
        Object result = "/index.html";
        httpRequest.generateResponseCode(result);
        HttpResponse httpResponse = httpRequest.toResponse();
        ResponseTemplate responseTemplate = httpResponse.chooseTemplate(templates);
        assertThat(responseTemplate instanceof ResponseTemplate200).isTrue();
    }
}