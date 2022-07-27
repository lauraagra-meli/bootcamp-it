package dh.meli.spring_elastic.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration // essa classe é de configuracao do spring para o elastic com a anotacao abaixo
@EnableElasticsearchRepositories(basePackages = "dh.meli.spring_elastic.repository")
public class Config {

    @Bean // manipulado/injetado/gerenciado pelo Spring
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .withBasicAuth("root", "root") // usuarip e senha
                .withConnectTimeout(10000) // tempo de conexao
                .withSocketTimeout(1000) // manda as conexoes
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    // metodo que vai conversar com o elastic (envio, recebimento, ...)
    @Bean // manipulado/injetado/gerenciado pelo Spring
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }
}
