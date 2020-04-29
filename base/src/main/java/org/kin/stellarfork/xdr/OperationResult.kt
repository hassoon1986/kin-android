// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten
package org.kin.stellarfork.xdr

import java.io.IOException

// === xdr source ============================================================
//  union OperationResult switch (OperationResultCode code)
//  {
//  case opINNER:
//      union switch (OperationType type)
//      {
//      case CREATE_ACCOUNT:
//          CreateAccountResult createAccountResult;
//      case PAYMENT:
//          PaymentResult paymentResult;
//      case PATH_PAYMENT:
//          PathPaymentResult pathPaymentResult;
//      case MANAGE_OFFER:
//          ManageOfferResult manageOfferResult;
//      case CREATE_PASSIVE_OFFER:
//          ManageOfferResult createPassiveOfferResult;
//      case SET_OPTIONS:
//          SetOptionsResult setOptionsResult;
//      case CHANGE_TRUST:
//          ChangeTrustResult changeTrustResult;
//      case ALLOW_TRUST:
//          AllowTrustResult allowTrustResult;
//      case ACCOUNT_MERGE:
//          AccountMergeResult accountMergeResult;
//      case INFLATION:
//          InflationResult inflationResult;
//      case MANAGE_DATA:
//          ManageDataResult manageDataResult;
//      }
//      tr;
//  default:
//      void;
//  };
//  ===========================================================================
class OperationResult {
    var discriminant: OperationResultCode? = null
    var tr: OperationResultTr? = null

    class OperationResultTr {
        var discriminant: OperationType? = null
        var createAccountResult: CreateAccountResult? = null
        var paymentResult: PaymentResult? = null
        var pathPaymentResult: PathPaymentResult? = null
        var manageOfferResult: ManageOfferResult? = null
        var createPassiveOfferResult: ManageOfferResult? = null
        var setOptionsResult: SetOptionsResult? = null
        var changeTrustResult: ChangeTrustResult? = null
        var allowTrustResult: AllowTrustResult? = null
        var accountMergeResult: AccountMergeResult? = null
        var inflationResult: InflationResult? = null
        var manageDataResult: ManageDataResult? = null

        companion object {
            @JvmStatic
            @Throws(IOException::class)
            fun encode(
                stream: XdrDataOutputStream,
                encodedOperationResultTr: OperationResultTr
            ) {
                stream.writeInt(encodedOperationResultTr.discriminant!!.value)
                when (encodedOperationResultTr.discriminant) {
                    OperationType.CREATE_ACCOUNT -> CreateAccountResult.encode(
                        stream,
                        encodedOperationResultTr.createAccountResult!!
                    )
                    OperationType.PAYMENT -> PaymentResult.encode(
                        stream,
                        encodedOperationResultTr.paymentResult!!
                    )
                    OperationType.PATH_PAYMENT -> PathPaymentResult.encode(
                        stream,
                        encodedOperationResultTr.pathPaymentResult!!
                    )
                    OperationType.MANAGE_OFFER -> ManageOfferResult.encode(
                        stream,
                        encodedOperationResultTr.manageOfferResult!!
                    )
                    OperationType.CREATE_PASSIVE_OFFER -> ManageOfferResult.encode(
                        stream,
                        encodedOperationResultTr.createPassiveOfferResult!!
                    )
                    OperationType.SET_OPTIONS -> SetOptionsResult.encode(
                        stream,
                        encodedOperationResultTr.setOptionsResult!!
                    )
                    OperationType.CHANGE_TRUST -> ChangeTrustResult.encode(
                        stream,
                        encodedOperationResultTr.changeTrustResult!!
                    )
                    OperationType.ALLOW_TRUST -> AllowTrustResult.encode(
                        stream,
                        encodedOperationResultTr.allowTrustResult!!
                    )
                    OperationType.ACCOUNT_MERGE -> AccountMergeResult.encode(
                        stream,
                        encodedOperationResultTr.accountMergeResult!!
                    )
                    OperationType.INFLATION -> InflationResult.encode(
                        stream,
                        encodedOperationResultTr.inflationResult!!
                    )
                    OperationType.MANAGE_DATA -> ManageDataResult.encode(
                        stream,
                        encodedOperationResultTr.manageDataResult!!
                    )
                }
            }

            @JvmStatic
            @Throws(IOException::class)
            fun decode(stream: XdrDataInputStream): OperationResultTr {
                val decodedOperationResultTr = OperationResultTr()
                val discriminant = OperationType.decode(stream)
                decodedOperationResultTr.discriminant = discriminant
                when (decodedOperationResultTr.discriminant) {
                    OperationType.CREATE_ACCOUNT ->
                        decodedOperationResultTr.createAccountResult = CreateAccountResult.decode(stream)
                    OperationType.PAYMENT ->
                        decodedOperationResultTr.paymentResult = PaymentResult.decode(stream)
                    OperationType.PATH_PAYMENT ->
                        decodedOperationResultTr.pathPaymentResult = PathPaymentResult.decode(stream)
                    OperationType.MANAGE_OFFER ->
                        decodedOperationResultTr.manageOfferResult = ManageOfferResult.decode(stream)
                    OperationType.CREATE_PASSIVE_OFFER ->
                        decodedOperationResultTr.createPassiveOfferResult = ManageOfferResult.decode(stream)
                    OperationType.SET_OPTIONS ->
                        decodedOperationResultTr.setOptionsResult = SetOptionsResult.decode(stream)
                    OperationType.CHANGE_TRUST ->
                        decodedOperationResultTr.changeTrustResult = ChangeTrustResult.decode(stream)
                    OperationType.ALLOW_TRUST ->
                        decodedOperationResultTr.allowTrustResult = AllowTrustResult.decode(stream)
                    OperationType.ACCOUNT_MERGE ->
                        decodedOperationResultTr.accountMergeResult = AccountMergeResult.decode(stream)
                    OperationType.INFLATION ->
                        decodedOperationResultTr.inflationResult = InflationResult.decode(stream)
                    OperationType.MANAGE_DATA ->
                        decodedOperationResultTr.manageDataResult = ManageDataResult.decode(stream)
                }
                return decodedOperationResultTr
            }
        }
    }

    companion object {
        @JvmStatic
        @Throws(IOException::class)
        fun encode(
            stream: XdrDataOutputStream,
            encodedOperationResult: OperationResult
        ) {
            stream.writeInt(encodedOperationResult.discriminant!!.value)
            when (encodedOperationResult.discriminant) {
                OperationResultCode.opINNER -> OperationResultTr.encode(
                    stream,
                    encodedOperationResult.tr!!
                )
                else -> {
                }
            }
        }

        @JvmStatic
        @Throws(IOException::class)
        fun decode(stream: XdrDataInputStream): OperationResult {
            val decodedOperationResult = OperationResult()
            val discriminant = OperationResultCode.decode(stream)
            decodedOperationResult.discriminant = discriminant
            when (decodedOperationResult.discriminant) {
                OperationResultCode.opINNER -> decodedOperationResult.tr =
                    OperationResultTr.decode(stream)
                else -> {
                }
            }
            return decodedOperationResult
        }
    }
}
