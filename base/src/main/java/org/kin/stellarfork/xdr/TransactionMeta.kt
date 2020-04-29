// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten
package org.kin.stellarfork.xdr

import java.io.IOException

// === xdr source ============================================================
//  union TransactionMeta switch (int v)
//  {
//  case 0:
//      OperationMeta operations<>;
//  };
//  ===========================================================================
class TransactionMeta {
    var discriminant: Int? = null
    var operations: Array<OperationMeta?> = arrayOfNulls(0)

    companion object {
        @JvmStatic
        @Throws(IOException::class)
        fun encode(
            stream: XdrDataOutputStream,
            encodedTransactionMeta: TransactionMeta
        ) {
            stream.writeInt(encodedTransactionMeta.discriminant!!.toInt())
            when (encodedTransactionMeta.discriminant) {
                0 -> {
                    val operationssize = encodedTransactionMeta.operations.size
                    stream.writeInt(operationssize)
                    var i = 0
                    while (i < operationssize) {
                        OperationMeta.encode(stream, encodedTransactionMeta.operations[i]!!)
                        i++
                    }
                }
            }
        }

        @JvmStatic
        @Throws(IOException::class)
        fun decode(stream: XdrDataInputStream): TransactionMeta {
            val decodedTransactionMeta = TransactionMeta()
            val discriminant = stream.readInt()
            decodedTransactionMeta.discriminant = discriminant
            when (decodedTransactionMeta.discriminant) {
                0 -> {
                    val operationssize = stream.readInt()
                    decodedTransactionMeta.operations = arrayOfNulls(operationssize)
                    var i = 0
                    while (i < operationssize) {
                        decodedTransactionMeta.operations[i] = OperationMeta.decode(stream)
                        i++
                    }
                }
            }
            return decodedTransactionMeta
        }
    }
}
