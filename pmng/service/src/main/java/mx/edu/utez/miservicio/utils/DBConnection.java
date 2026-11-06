package mx.edu.utez.miservicio.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
//Con la anotación Configuration este archivo se ejecutará como configuración del runtime
public class DBConnection {
    @Value("${db.host}")
    private String DBHost;
    @Value("${db.name}")
    private String DBName;
    @Value("${db.port}")
    private String DBPort;
    @Value("${db.user}")
    private String DBUser;
    @Value("${db.password}")
    private String DBPassword;

    @Bean
    public DataSource getConnection() {
        DriverManagerDataSource src = new DriverManagerDataSource();
        src.setUrl(String.format("jdbc:mysql://%s:%s/%s", DBHost, DBPort, DBName));
        /*
         * 1- página web: com.mysql
         * 2- gta SA: cj
         * 3- protocolo: jdbc
         * 4- Driver
         * */
        src.setDriverClassName("com.mysql.cj.jdbc.Driver");
        src.setUsername(DBUser);
        src.setPassword(DBPassword);
        return src;
    }
}
