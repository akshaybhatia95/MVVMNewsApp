package db

import androidx.room.TypeConverter
import model.Source


class Converters {

    @TypeConverter
    fun fromSource(source: model.Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }

}