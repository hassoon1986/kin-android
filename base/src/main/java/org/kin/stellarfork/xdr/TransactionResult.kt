// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten
package org.kin.stellarfork.xdr

import java.io.IOException

// === xdr source ============================================================
//  struct TransactionResult
//  {
//      int64 feeCharged; // actual fee charged for the transaction
//
//      union switch (TransactionResultCode code)
//      {
//      case txSUCCESS:
//      case txFAILED:
//          OperationResult results<>;
//      default:
//          void;
//      }
//      result;
//
//      // reserved for future use
//      union switch (int v)
//      {
//      case 0:
//          void;
//      }
//      ext;
//  };
//  ===========================================================================
class TransactionResult {
    var feeCharged: Int64? = null
    var result: TransactionResultResult? = null
    var ext: TransactionResultExt? = null

    class TransactionResultResult {
        var discriminant: TransactionResultCode? = null
        var results: Array<OperationResult?> = arrayOfNulls(0)

        companion object {
            @JvmStatic
            @Throws(IOException::class)
            fun encode(
                stream: XdrDataOutputStream,
                encodedTransactionResultResult: TransactionResultResult
            ) {
                stream.writeInt(encodedTransactionResultResult.discriminant!!.value)
                when (encodedTransactionResultResult.discriminant) {
                    TransactionResultCode.txSUCCESS, TransactionResultCode.txFAILED -> {
                        val resultssize = encodedTransactionResultResult.results.size
                        stream.writeInt(resultssize)
                        var i = 0
                        while (i < resultssize) {
                            OperationResult.encode(
                                stream,
                                encodedTransactionResultResult.results[i]!!
                            )
                            i++
                        }
                    }
                    else -> {
                    }
                }
            }

            @JvmStatic
            @Throws(IOException::class)
            fun decode(stream: XdrDataInputStream): TransactionResultResult {
                val decodedTransactionResultResult =
                    TransactionResultResult()
                val discriminant = TransactionResultCode.decode(stream)
                decodedTransactionResultResult.discriminant = discriminant
                when (decodedTransactionResultResult.discriminant) {
                    TransactionResultCode.txSUCCESS, TransactionResultCode.txFAILED -> {
                        val resultssize = stream.readInt()
                        decodedTransactionResultResult.results =
                            arrayOfNulls(resultssize)
                        var i = 0
                        while (i < resultssize) {
                            decodedTransactionResultResult.results[i] =
                                OperationResult.decode(stream)
                            i++
                        }
                    }
                    else -> {
                    }
                }
                return decodedTransactionResultResult
            }
        }
    }

    class TransactionResultExt {
        var discriminant: Int? = null

        companion object {
            @JvmStatic
            @Throws(IOException::class)
            fun encode(
                stream: XdrDataOutputStream,
                encodedTransactionResultExt: TransactionResultExt
            ) {
                stream.writeInt(encodedTransactionResultExt.discriminant!!.toInt())
                when (encodedTransactionResultExt.discriminant) {
                    0 -> {
                    }
                }
            }

            @JvmStatic
            @Throws(IOException::class)
            fun decode(stream: XdrDataInputStream): TransactionResultExt {
                val decodedTransactionResultExt = TransactionResultExt()
                val discriminant = stream.readInt()
                decodedTransactionResultExt.discriminant = discriminant
                when (decodedTransactionResultExt.discriminant) {
                    0 -> {
                    }
                }
                return decodedTransactionResultExt
            }
        }
    }

    companion object {
        @JvmStatic
        @Throws(IOException::class)
        fun encode(
            stream: XdrDataOutputStream,
            encodedTransactionResult: TransactionResult
        ) {
            Int64.encode(stream, encodedTransactionResult.feeCharged!!)
            TransactionResultResult.encode(stream, encodedTransactionResult.result!!)
            TransactionResultExt.encode(stream, encodedTransactionResult.ext!!)
        }

        @JvmStatic
        @Throws(IOException::class)
        fun decode(stream: XdrDataInputStream): TransactionResult {
            val decodedTransactionResult = TransactionResult()
            decodedTransactionResult.feeCharged = Int64.decode(stream)
            decodedTransactionResult.result = TransactionResultResult.decode(stream)
            decodedTransactionResult.ext = TransactionResultExt.decode(stream)
            return decodedTransactionResult
        }
    }
}
