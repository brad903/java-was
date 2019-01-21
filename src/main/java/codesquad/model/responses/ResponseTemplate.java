package codesquad.model.responses;

import codesquad.model.Header;

import java.io.DataOutputStream;

public interface ResponseTemplate {

    byte[] header(DataOutputStream dos, Header header) throws Exception;

    void body(DataOutputStream dos, byte[] body);

}
