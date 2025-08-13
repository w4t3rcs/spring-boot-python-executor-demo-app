package io.w4t3rcs.demo;

import io.w4t3rcs.python.PythonGrpcServerContainer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {
    @Bean
    @ServiceConnection
    PythonGrpcServerContainer pythonGrpcServerContainer() {
        return new PythonGrpcServerContainer("w4t3rcs/spring-boot-python-executor-python-grpc-server")
                .withAdditionalImports(new String[]{"scikit-learn", "numpy", "pandas", "scipy"});
    }

//    @Bean
//    @ServiceConnection
//    PythonRestServerContainer pythonRestServerContainer() {
//        return new PythonRestServerContainer("w4t3rcs/spring-boot-python-executor-python-rest-server")
//                .withAdditionalImports(new String[]{"scikit-learn", "numpy", "pandas", "scipy"});
//    }
}
