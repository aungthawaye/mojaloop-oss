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

import io.mojaloop.common.fspiop.model.core.Currency;
import io.mojaloop.common.fspiop.model.core.PartyIdInfo;
import io.mojaloop.common.fspiop.model.core.PartyPersonalInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Data model for the complex type Party.
 **/

@JsonTypeName("Party")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2025-07-11T07:50:32.899106+06:30[Asia/Rangoon]", comments = "Generator version: 7.13.0")
public class Party   {
  private PartyIdInfo partyIdInfo;
  private String merchantClassificationCode;
  private String name;
  private PartyPersonalInfo personalInfo;
  private @Valid List<Currency> supportedCurrencies = new ArrayList<>();

  public Party() {
  }

  @JsonCreator
  public Party(
    @JsonProperty(required = true, value = "partyIdInfo") PartyIdInfo partyIdInfo
  ) {
    this.partyIdInfo = partyIdInfo;
  }

  /**
   **/
  public Party partyIdInfo(PartyIdInfo partyIdInfo) {
    this.partyIdInfo = partyIdInfo;
    return this;
  }

  
  @JsonProperty(required = true, value = "partyIdInfo")
  @NotNull @Valid public PartyIdInfo getPartyIdInfo() {
    return partyIdInfo;
  }

  @JsonProperty(required = true, value = "partyIdInfo")
  public void setPartyIdInfo(PartyIdInfo partyIdInfo) {
    this.partyIdInfo = partyIdInfo;
  }

  /**
   * A limited set of pre-defined numbers. This list would be a limited set of numbers identifying a set of popular merchant types like School Fees, Pubs and Restaurants, Groceries, etc.
   **/
  public Party merchantClassificationCode(String merchantClassificationCode) {
    this.merchantClassificationCode = merchantClassificationCode;
    return this;
  }

  
  @JsonProperty("merchantClassificationCode")
   @Pattern(regexp="^[\\d]{1,4}$")public String getMerchantClassificationCode() {
    return merchantClassificationCode;
  }

  @JsonProperty("merchantClassificationCode")
  public void setMerchantClassificationCode(String merchantClassificationCode) {
    this.merchantClassificationCode = merchantClassificationCode;
  }

  /**
   * Name of the Party. Could be a real name or a nickname.
   **/
  public Party name(String name) {
    this.name = name;
    return this;
  }

  
  @JsonProperty("name")
   @Size(min=1,max=128)public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public Party personalInfo(PartyPersonalInfo personalInfo) {
    this.personalInfo = personalInfo;
    return this;
  }

  
  @JsonProperty("personalInfo")
  @Valid public PartyPersonalInfo getPersonalInfo() {
    return personalInfo;
  }

  @JsonProperty("personalInfo")
  public void setPersonalInfo(PartyPersonalInfo personalInfo) {
    this.personalInfo = personalInfo;
  }

  /**
   * Currencies in which the party can receive funds.
   **/
  public Party supportedCurrencies(List<Currency> supportedCurrencies) {
    this.supportedCurrencies = supportedCurrencies;
    return this;
  }

  
  @JsonProperty("supportedCurrencies")
   @Size(min=0,max=16)public List<Currency> getSupportedCurrencies() {
    return supportedCurrencies;
  }

  @JsonProperty("supportedCurrencies")
  public void setSupportedCurrencies(List<Currency> supportedCurrencies) {
    this.supportedCurrencies = supportedCurrencies;
  }

  public Party addSupportedCurrenciesItem(Currency supportedCurrenciesItem) {
    if (this.supportedCurrencies == null) {
      this.supportedCurrencies = new ArrayList<>();
    }

    this.supportedCurrencies.add(supportedCurrenciesItem);
    return this;
  }

  public Party removeSupportedCurrenciesItem(Currency supportedCurrenciesItem) {
    if (supportedCurrenciesItem != null && this.supportedCurrencies != null) {
      this.supportedCurrencies.remove(supportedCurrenciesItem);
    }

    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Party party = (Party) o;
    return Objects.equals(this.partyIdInfo, party.partyIdInfo) &&
        Objects.equals(this.merchantClassificationCode, party.merchantClassificationCode) &&
        Objects.equals(this.name, party.name) &&
        Objects.equals(this.personalInfo, party.personalInfo) &&
        Objects.equals(this.supportedCurrencies, party.supportedCurrencies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(partyIdInfo, merchantClassificationCode, name, personalInfo, supportedCurrencies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Party {\n");
    
    sb.append("    partyIdInfo: ").append(toIndentedString(partyIdInfo)).append("\n");
    sb.append("    merchantClassificationCode: ").append(toIndentedString(merchantClassificationCode)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    personalInfo: ").append(toIndentedString(personalInfo)).append("\n");
    sb.append("    supportedCurrencies: ").append(toIndentedString(supportedCurrencies)).append("\n");
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

