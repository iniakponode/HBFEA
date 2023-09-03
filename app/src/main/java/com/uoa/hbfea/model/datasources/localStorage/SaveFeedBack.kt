package com.uoa.hbfea.model.datasources.localStorage

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.opencsv.CSVWriter
import java.io.IOException

@RequiresApi(Build.VERSION_CODES.Q)
private fun saveDataToExternalStorage(
    report: String,
    selectedOption: Boolean,
    feedbackText: String,
    selectedTextQantiRating: String,
    context: Context
) {
    val fileName = "report_and_responses.csv"

    try {
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
            put(MediaStore.MediaColumns.MIME_TYPE, "text/csv")
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS)
        }

        val resolver = context.contentResolver
        val uri = resolver.insert(
            MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY),
            contentValues
        )

        uri?.let { fileUri ->
            resolver.openOutputStream(fileUri, "wa")?.use { outputStream ->
                CSVWriter(outputStream.writer()).use { writer ->
                    val fileExists = fileUriExists(fileUri, context)

                    // If the file doesn't exist, write the header
                    if (!fileExists) {
                        writer.writeNext(
                            arrayOf(
                                "Report",
                                "Response",
                                "Feedback",
                                "QuantitativeRating",
                                "QualitativeRating"
                            )
                        )
                    }

                    writer.writeNext(
                        arrayOf(
                            report,
                            selectedOption.toString(),
                            feedbackText,
                            selectedTextQantiRating
                        )
                    )

                    // File saved successfully
                    Toast.makeText(context, "Successfully saved files to phone", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
        // File saving failed
        Toast.makeText(context, "Saving Files to Phone Failed", Toast.LENGTH_LONG).show()
    }
}

private fun fileUriExists(fileUri: Uri,context: Context): Boolean {
    val resolver = context.contentResolver
    val cursor = resolver.query(fileUri, null, null, null, null)
    val exists = cursor != null && cursor.moveToFirst()
    cursor?.close()
    return exists
}


// ...



