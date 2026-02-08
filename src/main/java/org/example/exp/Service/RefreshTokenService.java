package org.example.exp.Service;


import org.example.exp.Repository.RefreshTokenRepository;
import org.example.exp.Repository.UserRepository;
import org.example.exp.entities.RefreshToken;
import org.example.exp.entities.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Ref;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Autowired RefreshTokenRepository refreshTokenRepository;
    @Autowired UserRepository userRepository;

    public RefreshToken createRefreshToken(String username){
        UserInfo userInfoEx =userRepository.findByUsername(username);
        RefreshToken refreshToken= RefreshToken.builder().userInfo(userInfoEx).token(UUID.randomUUID().toString()).expiryDate(Instant.now().plusMillis(60000))
                .build();
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken token){
        if(token.getExpiryDate().compareTo(Instant.now())<0){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken()+"Refresh token is there");
        }
        return token;
    }

    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.findByToken(token);

    }
}


