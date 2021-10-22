package PUJ.vjezba3;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Reader {

	public MainController configureSensors() throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		MainController mc = mapper.readValue(
				new File(
						"C:\\Users\\Korisnik\\Desktop\\PUJ\\vjezba3\\src\\main\\java\\PUJ\\vjezba3\\SensorConfig.json"),
				MainController.class);
		return mc;

	}

}
