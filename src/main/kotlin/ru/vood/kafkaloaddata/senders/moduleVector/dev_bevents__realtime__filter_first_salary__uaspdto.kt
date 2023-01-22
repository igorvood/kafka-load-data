package ru.vood.kafkaloaddata.senders.moduleVector

import kotlinx.serialization.encodeToString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.config.prop.CountProperties
import ru.vood.kafkaloaddata.dto.Identity
import ru.vood.kafkaloaddata.dto.SerialisationConst
import ru.vood.kafkaloaddata.producer.MessageProducerInterface
import ru.vood.kafkaloaddata.senders.ToTopicLoader
import ru.vood.kafkaloaddata.senders.enrichment.way4.dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto
import java.util.*
import kotlinx.serialization.Serializable
import ru.vood.kafkaloaddata.dto.SomeDto
import ru.vood.kafkaloaddata.senders.enrichment.way4Flat.dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdtoFlat

@Service
class dev_bevents__realtime__filter_first_salary__uaspdto (
    override val messageProducer: MessageProducerInterface<String, String>,
    override val countProperties: CountProperties
) : ToTopicLoader<SomeDto> {

    override val topicName: String
        get() = "dev_bevents__realtime__filter_first_salary__uaspdto"
    override val logger: Logger = LoggerFactory.getLogger(
        dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdtoFlat::class.java
    )

    override val timeOut: Optional<Int>
        get() = Optional.empty()

    override val generateFun: (Long) -> SomeDto = { id ->
        val decodeFromString =
            SerialisationConst
                .customJson.decodeFromString(SomeDto.serializer(), jsonValid2)

        val someDto = SomeDto(
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

        decodeFromString
    }

    override fun json(t: SomeDto): String = SerialisationConst.customJson.encodeToString(t)

    companion object{
        const val validJson = """
            {
  "id": "49472283",
  "dataInt": {
    "COUNT_PENS": 0,
    "EVENT_CNT": 1,
    "COUNT_POS": 0,
    "COUNT_SAL": 0,
    "COUNT_REP": 0,
    "currency_scale": 1,
    "COUNT_POS_CARD": 0
  },
  "dataLong": {
    "DATE_FIRST_SAL": 0,
    "DATE_LAST_SAL": 0,
    "effective_date": 1657152000000,
    "sys_begin_process": 1674218137088,
    "processing_datetime": 1674218090000,
    "FIRST_DAYS_FOR_LAST_DAYS": 0,
    "event_dttm": 1674218090000,
    "transaction_datetime": 1674228890000,
    "exchange_dttm": 1674218090000,
    "DATE_LAST_PENS": 0
  },
  "dataFloat": {},
  "dataDouble": {},
  "dataDecimal": {
    "currency_price": 1,
    "transaction_amount": 30,
    "amount": 23000,
    "base_amount_w4": 23000,
    "AMOUNT_ALL": 0
  },
  "dataString": {
    "source_system_w4": "WAY4",
    "kbo": "731500-02",
    "card_expire_w4": "2607",
    "customer_id": "39472283",
    "processing_result_code": "0",
    "MASK_CARD_NUMBER": "111122******4444",
    "card_expiration_dt": "2030-12-30",
    "card_ps_funding_source": "Credit",
    "system-classification": "RTO_First_pension_57_case",
    "customer_id_and_masked_card_number": "49472283;111122******4444",
    "transaction_currency": "RUR",
    "source_account": "40914810200009000369",
    "card_type_cd": "debet",
    "salary_serv_pack_flg": "N",
    "account_type": "MS",
    "kbo_w4": "731500-02",
    "salary_card_type_flg": "Y",
    "processing_date_string": "2023-01-20T12:34:50.478Z",
    "card_masked_pan": "111122******4444",
    "package_nm": "PRIVILEGE",
    "contract_card_type_cd": "MRMCSMR",
    "terminal_id": "11111111",
    "processing_resolution": "Accepted",
    "payment_system_desc": "MIR",
    "is_virtual_card_flg": "Y",
    "audit_rrn": "LSGGDATALASZ",
    "operation_id": "581881913",
    "hash_card_number": "f2a6853a6ee5c4a8aafa1f7f50e5aa07022ca0d367764522a977594cffdf442f",
    "salary_project_flg": "N",
    "source_system_cd": "WAY4",
    "source_account_w4": "40914810200009000369",
    "audit_srn": "IUSAWKQC2UNE",
    "service_type": "I5",
    "audit_auth_code": "125887",
    "payment_scheme_w4": "Mastercard",
    "exchange_currency": "RUR",
    "sys_process_ms": "59.",
    "salary_account_scheme_flg": "N",
    "local_id": "39472283",
    "pos_flg": "N",
    "action_type": "Presentment",
    "calculate-mdm_id": "49472283",
    "account_num": "11223344556677889900",
    "base_currency_w4": "RUR",
    "payment_direction": "Debit"
  },
  "dataBoolean": {
    "is_income": true,
    "is_pension": true,
    "system_is_update_pens": true
  },
  "uuid": "283275cf-9b55-430e-902d-f658b37641b0",
  "process_timestamp": 1674218137899
}
        """
    }


    val jsonValid2 = """
        {
          "id": "56597654",
          "dataInt": {
            "COUNT_PENS": 0,
            "COUNT_POS": 0,
            "COUNT_SAL": 0,
            "COUNT_REP": 0,
            "currency_scale": 1,
            "COUNT_POS_CARD": 0
          },
          "dataLong": {
            "DATE_FIRST_SAL": 0,
            "DATE_LAST_SAL": 0,
            "effective_date": 1649808000000,
            "sys_begin_process": 1674220044517,
            "processing_datetime": 1674219998000,
            "FIRST_DAYS_FOR_LAST_DAYS": 0,
            "transaction_datetime": 1674230798000,
            "exchange_dttm": 1674219998000,
            "DATE_LAST_PENS": 0
          },
          "dataFloat": {},
          "dataDouble": {},
          "dataDecimal": {
            "transaction_amount": 1000,
            "base_amount_w4": -2300,
            "currency_price": 76.3978,
            "AMOUNT_ALL": 0
          },
          "dataString": {
            "source_system_w4": "WAY4",
            "tagged_data_wallet_type": "MirPay",
            "card_expire_w4": "2607",
            "customer_id": "46597654",
            "processing_result_code": "0",
            "OPERATION_STATUS": "SUCCESS",
            "terminal_type": "POS",
            "MASK_CARD_NUMBER": "111122******4444",
            "card_expiration_dt": "2030-12-30",
            "card_ps_funding_source": "Prepaid",
            "system-classification": "RTO_48_case",
            "customer_id_and_masked_card_number": "56597654;111122******4444",
            "transaction_currency": "USD",
            "source_account": "40914810200009000369",
            "card_type_cd": "debet",
            "salary_serv_pack_flg": "N",
            "salary_card_type_flg": "Y",
            "processing_date_string": "2023-01-20T13:06:38.257Z",
            "card_masked_pan": "111122******4444",
            "package_nm": "PRIVILEGE",
            "contract_card_type_cd": "MRMCSMR",
            "terminal_id": "11111111",
            "processing_resolution": "Accepted",
            "payment_system_desc": "MIR",
            "is_virtual_card_flg": "Y",
            "audit_rrn": "1ST63EJBV02D",
            "operation_id": "980485145",
            "mcc": "4830",
            "hash_card_number": "f2a6853a6ee5c4a8aafa1f7f50e5aa07022ca0d367764522a977594cffdf442f",
            "salary_project_flg": "N",
            "source_system_cd": "WAY4",
            "source_account_w4": "40914810200009000369",
            "audit_srn": "RBXXOZDY7EL6",
            "service_type": "TKN_TAR",
            "audit_auth_code": "181977",
            "payment_scheme_w4": "MIR",
            "exchange_currency": "USD",
            "sys_process_ms": "22.",
            "salary_account_scheme_flg": "N",
            "local_id": "46597654",
            "pos_flg": "N",
            "action_type": "Authorization",
            "calculate-mdm_id": "56597654",
            "account_num": "11223344556677889900",
            "base_currency_w4": "RUR",
            "payment_direction": "Debit"
          },
          "dataBoolean": {},
          "uuid": "f7951d17-30f8-4d5c-903a-4ce472b72744",
          "process_timestamp": 1674220045258
        }
    """.trimIndent()

}

