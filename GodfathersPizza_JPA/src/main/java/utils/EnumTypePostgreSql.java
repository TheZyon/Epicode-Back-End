package utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.EnumType;

/*
 * classe che comunica ad Hibernate di mappare 
 * una enum scritta in Java nella corrispondente enum del DB
 * 
 * vedi articolo https://thorben-janssen.com/hibernate-enum-mappings/
 * 
 * sez. "Create a DB-Specific Enum Type"
 */


public class EnumTypePostgreSql extends EnumType {

	@Override
    public void nullSafeSet(PreparedStatement st, Object value, int index,
            SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if(value == null) {
            st.setNull( index, Types.OTHER );
        }
        else {
            st.setObject( index, value.toString(), Types.OTHER );
        }
    }
 
     
}

