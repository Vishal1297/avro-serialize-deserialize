package org.test

import java.io.File
import org.apache.avro.file.DataFileReader
import org.apache.avro.specific.SpecificDatumReader
import org.apache.avro.io.DatumReader


class Deserialize {

    fun deserializeClass(clazz: Any) {
        //DeSerializing the objects
        val empDatumReader: DatumReader<Any> = SpecificDatumReader(clazz.javaClass)
        //Instantiating DataFileReader
        val dataFileReader: DataFileReader<Any> =
            DataFileReader(File("./src/main/avro/emp.avro"), empDatumReader)
        var obj: Any? = null
        while (dataFileReader.hasNext()) {
            obj = dataFileReader.next(obj)
            println(obj)
        }
    }
}