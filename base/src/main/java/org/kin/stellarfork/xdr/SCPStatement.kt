// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten
package org.kin.stellarfork.xdr

import org.kin.stellarfork.xdr.SCPBallot.Companion.encode
import java.io.IOException

// === xdr source ============================================================
//  struct SCPStatement
//  {
//      NodeID nodeID;    // v
//      uint64 slotIndex; // i
//
//      union switch (SCPStatementType type)
//      {
//      case SCP_ST_PREPARE:
//          struct
//          {
//              Hash quorumSetHash;       // D
//              SCPBallot ballot;         // b
//              SCPBallot* prepared;      // p
//              SCPBallot* preparedPrime; // p'
//              uint32 nC;                // c.n
//              uint32 nH;                // h.n
//          } prepare;
//      case SCP_ST_CONFIRM:
//          struct
//          {
//              SCPBallot ballot;   // b
//              uint32 nPrepared;   // p.n
//              uint32 nCommit;     // c.n
//              uint32 nH;          // h.n
//              Hash quorumSetHash; // D
//          } confirm;
//      case SCP_ST_EXTERNALIZE:
//          struct
//          {
//              SCPBallot commit;         // c
//              uint32 nH;                // h.n
//              Hash commitQuorumSetHash; // D used before EXTERNALIZE
//          } externalize;
//      case SCP_ST_NOMINATE:
//          SCPNomination nominate;
//      }
//      pledges;
//  };
//  ===========================================================================
class SCPStatement {
    var nodeID: NodeID? = null
    var slotIndex: Uint64? = null
    var pledges: SCPStatementPledges? = null

    class SCPStatementPledges {
        var discriminant: SCPStatementType? = null
        var prepare: SCPStatementPrepare? = null
        var confirm: SCPStatementConfirm? = null
        var externalize: SCPStatementExternalize? = null
        var nominate: SCPNomination? = null

        class SCPStatementPrepare {
            var quorumSetHash: Hash? = null
            var ballot: SCPBallot? = null
            var prepared: SCPBallot? = null
            var preparedPrime: SCPBallot? = null
            var nC: Uint32? = null
            var nH: Uint32? = null

            companion object {
                @JvmStatic
                @Throws(IOException::class)
                fun encode(
                    stream: XdrDataOutputStream,
                    encodedSCPStatementPrepare: SCPStatementPrepare
                ) {
                    Hash.encode(
                        stream,
                        encodedSCPStatementPrepare.quorumSetHash!!
                    )
                    encode(stream, encodedSCPStatementPrepare.ballot!!)
                    if (encodedSCPStatementPrepare.prepared != null) {
                        stream.writeInt(1)
                        encode(stream, encodedSCPStatementPrepare.prepared!!)
                    } else {
                        stream.writeInt(0)
                    }
                    if (encodedSCPStatementPrepare.preparedPrime != null) {
                        stream.writeInt(1)
                        encode(stream, encodedSCPStatementPrepare.preparedPrime!!)
                    } else {
                        stream.writeInt(0)
                    }
                    Uint32.encode(stream, encodedSCPStatementPrepare.nC!!)
                    Uint32.encode(stream, encodedSCPStatementPrepare.nH!!)
                }

                @JvmStatic
                @Throws(IOException::class)
                fun decode(stream: XdrDataInputStream): SCPStatementPrepare {
                    val decodedSCPStatementPrepare = SCPStatementPrepare()
                    decodedSCPStatementPrepare.quorumSetHash =
                        Hash.decode(stream)
                    decodedSCPStatementPrepare.ballot = SCPBallot.decode(stream)
                    val preparedPresent = stream.readInt()
                    if (preparedPresent != 0) {
                        decodedSCPStatementPrepare.prepared = SCPBallot.decode(stream)
                    }
                    val preparedPrimePresent = stream.readInt()
                    if (preparedPrimePresent != 0) {
                        decodedSCPStatementPrepare.preparedPrime = SCPBallot.decode(stream)
                    }
                    decodedSCPStatementPrepare.nC = Uint32.decode(stream)
                    decodedSCPStatementPrepare.nH = Uint32.decode(stream)
                    return decodedSCPStatementPrepare
                }
            }
        }

        class SCPStatementConfirm {
            var ballot: SCPBallot? = null
            var nPrepared: Uint32? = null
            var nCommit: Uint32? = null
            var nH: Uint32? = null
            var quorumSetHash: Hash? = null

            companion object {
                @JvmStatic
                @Throws(IOException::class)
                fun encode(
                    stream: XdrDataOutputStream,
                    encodedSCPStatementConfirm: SCPStatementConfirm
                ) {
                    encode(stream, encodedSCPStatementConfirm.ballot!!)
                    Uint32.encode(stream, encodedSCPStatementConfirm.nPrepared!!)
                    Uint32.encode(stream, encodedSCPStatementConfirm.nCommit!!)
                    Uint32.encode(stream, encodedSCPStatementConfirm.nH!!)
                    Hash.encode(
                        stream,
                        encodedSCPStatementConfirm.quorumSetHash!!
                    )
                }

                @JvmStatic
                @Throws(IOException::class)
                fun decode(stream: XdrDataInputStream): SCPStatementConfirm {
                    val decodedSCPStatementConfirm = SCPStatementConfirm()
                    decodedSCPStatementConfirm.ballot = SCPBallot.decode(stream)
                    decodedSCPStatementConfirm.nPrepared = Uint32.decode(stream)
                    decodedSCPStatementConfirm.nCommit = Uint32.decode(stream)
                    decodedSCPStatementConfirm.nH = Uint32.decode(stream)
                    decodedSCPStatementConfirm.quorumSetHash =
                        Hash.decode(stream)
                    return decodedSCPStatementConfirm
                }
            }
        }

        class SCPStatementExternalize {
            var commit: SCPBallot? = null
            var nH: Uint32? = null
            var commitQuorumSetHash: Hash? = null

            companion object {
                @JvmStatic
                @Throws(IOException::class)
                fun encode(
                    stream: XdrDataOutputStream,
                    encodedSCPStatementExternalize: SCPStatementExternalize
                ) {
                    encode(stream, encodedSCPStatementExternalize.commit!!)
                    Uint32.encode(stream, encodedSCPStatementExternalize.nH!!)
                    Hash.encode(
                        stream,
                        encodedSCPStatementExternalize.commitQuorumSetHash!!
                    )
                }

                @JvmStatic
                @Throws(IOException::class)
                fun decode(stream: XdrDataInputStream): SCPStatementExternalize {
                    val decodedSCPStatementExternalize = SCPStatementExternalize()
                    decodedSCPStatementExternalize.commit = SCPBallot.decode(stream)
                    decodedSCPStatementExternalize.nH = Uint32.decode(stream)
                    decodedSCPStatementExternalize.commitQuorumSetHash = Hash.decode(stream)
                    return decodedSCPStatementExternalize
                }
            }
        }

        companion object {
            @JvmStatic
            @Throws(IOException::class)
            fun encode(
                stream: XdrDataOutputStream,
                encodedSCPStatementPledges: SCPStatementPledges
            ) {
                stream.writeInt(encodedSCPStatementPledges.discriminant!!.value)
                when (encodedSCPStatementPledges.discriminant) {
                    SCPStatementType.SCP_ST_PREPARE -> SCPStatementPrepare.encode(
                        stream,
                        encodedSCPStatementPledges.prepare!!
                    )
                    SCPStatementType.SCP_ST_CONFIRM -> SCPStatementConfirm.encode(
                        stream,
                        encodedSCPStatementPledges.confirm!!
                    )
                    SCPStatementType.SCP_ST_EXTERNALIZE -> SCPStatementExternalize.encode(
                        stream,
                        encodedSCPStatementPledges.externalize!!
                    )
                    SCPStatementType.SCP_ST_NOMINATE -> SCPNomination.encode(
                        stream,
                        encodedSCPStatementPledges.nominate!!
                    )
                }
            }

            @JvmStatic
            @Throws(IOException::class)
            fun decode(stream: XdrDataInputStream): SCPStatementPledges {
                val decodedSCPStatementPledges = SCPStatementPledges()
                val discriminant = SCPStatementType.decode(stream)
                decodedSCPStatementPledges.discriminant = discriminant
                when (decodedSCPStatementPledges.discriminant) {
                    SCPStatementType.SCP_ST_PREPARE -> decodedSCPStatementPledges.prepare =
                        SCPStatementPrepare.decode(stream)
                    SCPStatementType.SCP_ST_CONFIRM -> decodedSCPStatementPledges.confirm =
                        SCPStatementConfirm.decode(stream)
                    SCPStatementType.SCP_ST_EXTERNALIZE -> decodedSCPStatementPledges.externalize =
                        SCPStatementExternalize.decode(stream)
                    SCPStatementType.SCP_ST_NOMINATE -> decodedSCPStatementPledges.nominate =
                        SCPNomination.decode(stream)
                }
                return decodedSCPStatementPledges
            }
        }
    }

    companion object {
        @JvmStatic
        @Throws(IOException::class)
        fun encode(stream: XdrDataOutputStream, encodedSCPStatement: SCPStatement) {
            NodeID.encode(stream, encodedSCPStatement.nodeID!!)
            Uint64.encode(stream, encodedSCPStatement.slotIndex!!)
            SCPStatementPledges.encode(stream, encodedSCPStatement.pledges!!)
        }

        @JvmStatic
        @Throws(IOException::class)
        fun decode(stream: XdrDataInputStream): SCPStatement {
            val decodedSCPStatement = SCPStatement()
            decodedSCPStatement.nodeID = NodeID.decode(stream)
            decodedSCPStatement.slotIndex = Uint64.decode(stream)
            decodedSCPStatement.pledges = SCPStatementPledges.decode(stream)
            return decodedSCPStatement
        }
    }
}
