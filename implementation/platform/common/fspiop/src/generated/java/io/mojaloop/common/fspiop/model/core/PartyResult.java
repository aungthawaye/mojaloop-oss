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
package io.mojaloop.common.fspiop.model.core;

import io.mojaloop.common.fspiop.model.core.ErrorInformation;
import io.mojaloop.common.fspiop.model.core.PartyIdInfo;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Data model for the complex type PartyResult.
 **/

@JsonTypeName("PartyResult")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2025-07-11T07:50:32.899106+06:30[Asia/Rangoon]", comments = "Generator version: 7.13.0")
public class PartyResult   {
  private PartyIdInfo partyId;
  private ErrorInformation errorInformation;

  public PartyResult() {
  }

  @JsonCreator
  public PartyResult(
    @JsonProperty(required = true, value = "partyId") PartyIdInfo partyId
  ) {
    this.partyId = partyId;
  }

  /**
   **/
  public PartyResult partyId(PartyIdInfo partyId) {
    this.partyId = partyId;
    return this;
  }

  
  @JsonProperty(required = true, value = "partyId")
  @NotNull @Valid public PartyIdInfo getPartyId() {
    return partyId;
  }

  @JsonProperty(required = true, value = "partyId")
  public void setPartyId(PartyIdInfo partyId) {
    this.partyId = partyId;
  }

  /**
   **/
  public PartyResult errorInformation(ErrorInformation errorInformation) {
    this.errorInformation = errorInformation;
    return this;
  }

  
  @JsonProperty("errorInformation")
  @Valid public ErrorInformation getErrorInformation() {
    return errorInformation;
  }

  @JsonProperty("errorInformation")
  public void setErrorInformation(ErrorInformation errorInformation) {
    this.errorInformation = errorInformation;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartyResult partyResult = (PartyResult) o;
    return Objects.equals(this.partyId, partyResult.partyId) &&
        Objects.equals(this.errorInformation, partyResult.errorInformation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(partyId, errorInformation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartyResult {\n");
    
    sb.append("    partyId: ").append(toIndentedString(partyId)).append("\n");
    sb.append("    errorInformation: ").append(toIndentedString(errorInformation)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

