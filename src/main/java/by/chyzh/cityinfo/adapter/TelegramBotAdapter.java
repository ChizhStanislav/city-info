package by.chyzh.cityinfo.adapter;

import by.chyzh.cityinfo.dto.CityDto;
import by.chyzh.cityinfo.exception.NotFoundException;
import by.chyzh.cityinfo.service.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@Log4j
@AllArgsConstructor
public class TelegramBotAdapter extends TelegramLongPollingBot {

    private final String botUsername;
    private final String botToken;
    private final CityService cityService;

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        try {
            CityDto city = cityService.findByName(message);
            sendMsg(update.getMessage().getChatId().toString(), city.getDescription());
        } catch (NotFoundException e) {
            sendMsg(update.getMessage().getChatId().toString(), e.getMessage());
        }
    }

    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.toString());
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

}
