package org.test

import org.apache.avro.Schema
import org.apache.avro.file.DataFileWriter
import org.apache.avro.io.DatumWriter
import org.apache.avro.specific.SpecificDatumWriter
import java.io.File


class Serialize {

    fun <T> serializeClass(clazz: Any, objectsList: MutableList<T>) {
        val empDatumWriter: DatumWriter<Any> = SpecificDatumWriter(clazz.javaClass)
        val empFileWriter: DataFileWriter<Any> = DataFileWriter(empDatumWriter)

        empFileWriter.create(
            Schema.Parser().parse(File("src/main/avro/emp.avsc")),
            File("src/main/avro/emp.avro")
        )

        empFileWriter.append(objectsList[0])
        empFileWriter.append(objectsList[1])
        empFileWriter.append(objectsList[2])

        empFileWriter.close()

        println("data successfully serialized")
    }
}