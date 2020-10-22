import org.eclipse.persistence.jaxb.MarshallerProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class MainXML {

    public static void main(String[] args) {
        Essai essai = new Essai();
        essai.setId(12);
        essai.setText("le nouveau text");
        essai.setAutre("aozheoazheuaz");

        try {
            // pr ne pas faire du xml par default
            System.setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory");

            JAXBContext context = JAXBContext.newInstance(Essai.class);
            Marshaller marshaller = context.createMarshaller();
            // format xml
            //marshaller.marshal(essai,new File("essai.xml"));

            marshaller.setProperty("jaxb.formatted.output",true);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            Essai e2 = (Essai) unmarshaller.unmarshal(new File("essai.xml"));
            System.out.println(e2);

            //propriete pr dire en quel format on sort
            marshaller.setProperty(MarshallerProperties.MEDIA_TYPE,"application/json");
            marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT,false);
            marshaller.marshal(essai,new File("essai.json"));

            unmarshaller.setProperty(MarshallerProperties.MEDIA_TYPE,"application/json");
            unmarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT,false);
            Essai e3 = (Essai) unmarshaller.unmarshal(new File("essai.json"));
            System.out.println(e3);



        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
