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

import io.mojaloop.common.fspiop.model.core.Money;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * An FXP will be able to specify a charge which it proposes to levy on the currency conversion operation using a FxCharge object.
 **/

@JsonTypeName("FxCharge")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2025-07-11T07:50:32.899106+06:30[Asia/Rangoon]", comments = "Generator version: 7.13.0")
public class FxCharge   {
  private String chargeType;
  private Money sourceAmount;
  private Money targetAmount;

  public FxCharge() {
  }

  @JsonCreator
  public FxCharge(
    @JsonProperty(required = true, value = "chargeType") String chargeType
  ) {
    this.chargeType = chargeType;
  }

  /**
   * A description of the charge which is being levied.
   **/
  public FxCharge chargeType(String chargeType) {
    this.chargeType = chargeType;
    return this;
  }

  
  @JsonProperty(required = true, value = "chargeType")
  @NotNull  @Size(min=1,max=32)public String getChargeType() {
    return chargeType;
  }

  @JsonProperty(required = true, value = "chargeType")
  public void setChargeType(String chargeType) {
    this.chargeType = chargeType;
  }

  /**
   **/
  public FxCharge sourceAmount(Money sourceAmount) {
    this.sourceAmount = sourceAmount;
    return this;
  }

  
  @JsonProperty("sourceAmount")
  @Valid public Money getSourceAmount() {
    return sourceAmount;
  }

  @JsonProperty("sourceAmount")
  public void setSourceAmount(Money sourceAmount) {
    this.sourceAmount = sourceAmount;
  }

  /**
   **/
  public FxCharge targetAmount(Money targetAmount) {
    this.targetAmount = targetAmount;
    return this;
  }

  
  @JsonProperty("targetAmount")
  @Valid public Money getTargetAmount() {
    return targetAmount;
  }

  @JsonProperty("targetAmount")
  public void setTargetAmount(Money targetAmount) {
    this.targetAmount = targetAmount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FxCharge fxCharge = (FxCharge) o;
    return Objects.equals(this.chargeType, fxCharge.chargeType) &&
        Objects.equals(this.sourceAmount, fxCharge.sourceAmount) &&
        Objects.equals(this.targetAmount, fxCharge.targetAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chargeType, sourceAmount, targetAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FxCharge {\n");
    
    sb.append("    chargeType: ").append(toIndentedString(chargeType)).append("\n");
    sb.append("    sourceAmount: ").append(toIndentedString(sourceAmount)).append("\n");
    sb.append("    targetAmount: ").append(toIndentedString(targetAmount)).append("\n");
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

