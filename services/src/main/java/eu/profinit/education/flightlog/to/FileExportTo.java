package eu.profinit.education.flightlog.to;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileExportTo {

    private String fileName;
    private MediaType contentType;
    private Charset encoding;
    private byte[] content;
}
