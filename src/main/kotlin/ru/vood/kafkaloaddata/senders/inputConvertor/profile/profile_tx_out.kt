package ru.vood.kafkaloaddata.senders.inputConvertor.profile

import kotlinx.serialization.encodeToString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.config.prop.CountProperties
import ru.vood.kafkaloaddata.dto.SerialisationConst
import ru.vood.kafkaloaddata.dto.SomeDto
import ru.vood.kafkaloaddata.producer.MessageProducerInterface
import ru.vood.kafkaloaddata.senders.ToTopicLoader
import ru.vood.kafkaloaddata.senders.enrichment.way4Flat.dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdtoFlat
import java.util.*

@Service
class profile_tx_out(
    override val messageProducer: MessageProducerInterface<String, String>,
    override val countProperties: CountProperties
) : ToTopicLoader<SomeDto> {

    override val topicName: String
        get() = "profile_tx_out"

    override val logger: Logger = LoggerFactory.getLogger(
        dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdtoFlat::class.java
    )

    override val timeOut: Optional<Int>
        get() = Optional.empty()

    override val generateFun: (Long) -> SomeDto = { id ->
        SomeDto(
            id.toString(),
            mutableMapOf(),
            mutableMapOf(),
            mutableMapOf(),
            mutableMapOf(),
            mutableMapOf(),
            mutableMapOf("global_id" to "global_id_$id"),
            mutableMapOf(),
            id.toString(),
            Calendar.getInstance().timeInMillis,
        )
    }

    override fun json(t: SomeDto): String = json

    companion object{
        val json ="""{
  "acngl": null,
  "atmd": null,
  "atmm": null,
  "badttx": "0",
  "bchseq": null,
  "bcrcd": null,
  "ben": null,
  "brcd": "2",
  "bseamt": null,
  "cc": "2",
  "event_dttm_prf": 2,
  "cdt": "2023-01-28",
  "chktyp": null,
  "cid": "88367207",
  "cls": "D",
  "cmpsav": null,
  "coa": "0.00",
  "cores": null,
  "crcd": "USD",
  "custcd": null,
  "dealid": null,
  "dir": null,
  "disc1": null,
  "disc2": null,
  "drcr": "CR",
  "dtlseq": "0",
  "efd": null,
  "efdcmp": "2022-07-25",
  "endbal": "41496.57",
  "etc": "DW",
  "fileid": null,
  "glsc": "401",
  "grp": "DDA",
  "ident": null,
  "int_": "0.00",
  "itc": "00100000A",
  "itc1": "0",
  "itc10": null,
  "itc11": null,
  "itc12": null,
  "itc13": null,
  "itc2": "0",
  "itc3": "1",
  "itc4": "0",
  "itc5": "0",
  "itc6": "0",
  "itc7": "0",
  "itc8": "0",
  "itc9": "A",
  "lnerc": null,
  "misc": "0.00",
  "msd": null,
  "mult": null,
  "negp": "0.00",
  "negpb": "0.00",
  "negpu": "0.00",
  "penalty": "0.00",
  "prin": "1000",
  "rate": null,
  "rec": "0.00",
  "recs": null,
  "rseq": null,
  "rty": null,
  "sif": "0",
  "sifptrs": null,
  "spr": "797928834",
  "swhld": "0.00",
  "sysbase": "14031.04",
  "tamt": "14031.04",
  "tcmt": "N625/0002-074881422.08.20",
  "tcsarl": "0",
  "tfr": "0.00",
  "tim": "180135",
  "tjd": "2022-07-25",
  "tlo": "oracleJDBCdriver",
  "tlodbinst": null,
  "tot": "14031.04",
  "trc": "1",
  "tresref": null,
  "trntype": null,
  "tsb": "8147",
  "tseq": "8147",
  "tso": "FCID#40817810414154018746~MRPC29#DW^14031.04~RCID#88888~ZAUTHMET#CIFID~ZCCODE#0~ZCHNL#BACKOFFICE~ZMRPC1030#~ZPKGID#MULTICARTA~ZROLE#1~ZTFEEFLG#1~ZTRNTYPE#731800-22~ZLINKTYP#ENTDEP~ZLINKID#88888~ZLINKSYS#",
  "ttamt2": "0.00",
  "udprin": null,
  "uid": "9ULBS",
  "uidt": null,
  "unapl": "0.00",
  "unc": "0.00",
  "vatlchg": "0.00",
  "vdt": null,
  "whld": "0.00",
  "xpdo": null,
  "zcrdcat": null,
  "zcrdtypgrp": null,
  "zdefpmt": "0.00",
  "zregion": "65",
  "ztsoatmc": null,
  "ztsoatmt": null,
  "ztsoauthid": null,
  "ztsochnl": "BACKOFFICE",
  "ztsodevtype": null,
  "ztsofccode": null,
  "ztsofeeseq": null,
  "ztsofeetyp": null,
  "ztsofndrec": null,
  "ztsofndsrc": null,
  "ztsotrntype": "731500-01"
}"""
    }
}