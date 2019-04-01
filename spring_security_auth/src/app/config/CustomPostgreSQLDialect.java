package app.config;

import org.hibernate.dialect.PostgreSQL95Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StringType;

public class CustomPostgreSQLDialect extends PostgreSQL95Dialect {
    public CustomPostgreSQLDialect() {
        super();
        registerFunction("lower", new SQLFunctionTemplate(new StringType(), "tr_lower(?1)"));
        registerFunction("upper", new SQLFunctionTemplate(new StringType(), "tr_upper(?1)"));
    }
}