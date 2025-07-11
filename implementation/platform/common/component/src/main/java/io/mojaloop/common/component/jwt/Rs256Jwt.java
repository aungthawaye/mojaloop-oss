/*-
 * ================================================================================
 * Mojaloop OSS
 * --------------------------------------------------------------------------------
 * Copyright (C) 2025 Open Source
 * --------------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ================================================================================
 */
package io.mojaloop.common.component.jwt;

import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;

public final class Rs256Jwt {

    private static final Logger LOGGER = LoggerFactory.getLogger(Rs256Jwt.class);

    private Rs256Jwt() { }

    public static Token sign(PrivateKey privateKey, Map<String, String> headers, String payload) {

        String token = Jwts
                           .builder()
                           .signWith(privateKey)
                           .header()
                           .add("typ", "JWT")
                           .add(headers)
                           .and()
                           .content(payload, "application/json")
                           .compact();

        String[] parts = token.split("\\.");

        return new Token(parts[0], parts[1], parts[2], token);
    }

    public static boolean verify(PublicKey publicKey, String token, String payload) {

        try {

            var content = new String(Jwts.parser().verifyWith(publicKey).build().parseSignedContent(token).getPayload(),
                                     StandardCharsets.UTF_8);

            return content.equals(payload);

        } catch (Exception e) {

            LOGGER.error("Error : {0}", e);
            return false;
        }
    }

    public record Token(String header, String body, String signature, String full) { }

}
