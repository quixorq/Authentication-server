package ru.obydennov.authorization.listeners;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import ru.obydennov.authorization.services.Impl.LoginAttemptServiceIml;
import ru.obydennov.authorization.utils.IpAddressExtractor;

@Component
@RequiredArgsConstructor
public final class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {
    private final LoginAttemptServiceIml loginAttemptService;
    private final IpAddressExtractor ipAddressExtractor;

    public void onApplicationEvent(AuthenticationSuccessEvent e) {
        loginAttemptService.loginSucceeded(ipAddressExtractor.getClientIP());
    }
}
