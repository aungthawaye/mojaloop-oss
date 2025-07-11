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
package io.mojaloop.common.fspiop.client.api.parties;

import io.mojaloop.common.component.retrofit.RetrofitService;
import io.mojaloop.common.fspiop.component.FspiopHeaders;
import io.mojaloop.common.fspiop.model.core.ErrorInformationResponse;
import io.mojaloop.common.fspiop.service.AccountLookUpService;
import io.mojaloop.common.fspiop.support.Destination;
import io.mojaloop.common.fspiop.support.ParticipantSettings;
import org.springframework.stereotype.Service;

@Service
class GetPartiesHandler implements GetParties {

    private final ParticipantSettings participantSettings;

    private final AccountLookUpService accountLookUpService;

    private final RetrofitService.ErrorDecoder<ErrorInformationResponse> errorDecoder;

    public GetPartiesHandler(ParticipantSettings participantSettings,
                             AccountLookUpService accountLookUpService,
                             RetrofitService.ErrorDecoder<ErrorInformationResponse> errorDecoder) {

        assert participantSettings != null;
        assert accountLookUpService != null;
        assert errorDecoder != null;

        this.participantSettings = participantSettings;
        this.accountLookUpService = accountLookUpService;
        this.errorDecoder = errorDecoder;
    }

    @Override
    public void getParties(Destination destination, String partyIdType, String partyId, String subId) {

        try {

            var fspiopHeaders = FspiopHeaders.Values.Parties.forRequest(this.participantSettings.fspId(), destination.destinationFspId());

            RetrofitService.invoke(this.accountLookUpService.getParty(fspiopHeaders, partyIdType, partyId), this.errorDecoder);

        } catch (RetrofitService.InvocationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getParties(Destination destination, String partyIdType, String partyId) {

        try {

            var fspiopHeaders = FspiopHeaders.Values.Parties.forRequest(this.participantSettings.fspId(), destination.destinationFspId());

            RetrofitService.invoke(this.accountLookUpService.getParty(fspiopHeaders, partyIdType, partyId), null);

        } catch (RetrofitService.InvocationException e) {
            throw new RuntimeException(e);
        }
    }

}
