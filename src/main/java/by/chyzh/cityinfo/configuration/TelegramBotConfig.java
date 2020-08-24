package by.chyzh.cityinfo.configuration;

import by.chyzh.cityinfo.adapter.TelegramBotAdapter;
import by.chyzh.cityinfo.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

@Log4j
@Configuration
@RequiredArgsConstructor
public class TelegramBotConfig {

    private final CityService cityService;

    @Value("${botUsername}")
    private String botUsername;

    @Value("${botToken}")
    private String botToken;

    @Bean
    public void telegramBotsApi() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new TelegramBotAdapter(botUsername, botToken, cityService));
        } catch (TelegramApiRequestException e) {
            log.error("BotUsername or botToken is incorrect!");
        }
    }

}
