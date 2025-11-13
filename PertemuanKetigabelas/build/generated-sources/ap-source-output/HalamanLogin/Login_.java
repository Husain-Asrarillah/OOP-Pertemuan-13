package HalamanLogin;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-11-13T15:06:59", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Login.class)
public class Login_ { 

    public static volatile SingularAttribute<Login, Date> waktuBuat;
    public static volatile SingularAttribute<Login, String> passwordHash;
    public static volatile SingularAttribute<Login, String> username;

}