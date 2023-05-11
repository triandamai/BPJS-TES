/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.data.remote

import com.bluehabit.bpjs.data.R
import com.bluehabit.bpjs.data.model.Program
import com.bluehabit.bpjs.data.model.Service

class ProgramData {
    companion object {
        val program: List<Program> = listOf(
            Program(
                id = 1,
                title = "Jaminan Hari Tua",
                description = "Berupa uang tunao yang besarnya merupakan nilai akumulasi iuran ditambah hasil pengembangnya",
                icon = R.drawable.ic_jam_hari_tua,
                available = true,
                benefit = listOf(
                    "Akumulasi iuran ditambah hasil pengembangan yang besarnya minimal setara rata-rata tingkat suku bunga deposito bank pemerintah"
                ),
                contribution = listOf(
                    "Besar Iuran Penerima Upa 2% Pekerja 3.7% Perusahaan(Dari Upah yang dilaporkan",
                    "Besar Iuran Bukan Penerima Upah 2%",
                    """
                        Besar Iuran Pekerja Migran Indonesia:\n
                        Rp 50.000.00(lima puluh ribut rupiah)\n
                        Rp 100.000.00(seratus ribut rupiah)
                    """.trimIndent()
                )
            ),
            Program(
                id = 2,
                title = "Jaminan Keceakaan Kerja",
                description = "Memberikan perlindungan atas risiko-risiko kecelakaan yang terjadi dalam hubungan kerja termasuk kecelakaan yang terjadi dalam perjalanan dari rumah menuju tempat kerja atau sebaliknya dan penyakit yang disebabkan oleh lingkungan kerja",
                icon = R.drawable.ic_jam_kecelakaan,
                available = true,
                benefit = listOf(
                    "Pelayanan kesehatan sesuai kebutuhan medis",
                    """
                        Santunan berupa uang yang meliputi:\n
                        a. Penggantian biaya transportasi 
                        b.Santunan sementara tidak mampu bekerja
                        c.santunan cacat
                    """.trimIndent()
                ),
                contribution = listOf(
                    "Penerima Upah: 0.24% - 1.74% dari upah sebulan",
                    "Bukan Penerimah Upah: 1%",
                    """
                       Pekerja Jasa Konstruksi terdiri dari:
                       a. Pekerja Jasa Konstruksi dengan komponen upah tercantum dan diketahui, iuran JKK sebesar 1.75% dari upah sebulan
                    """.trimIndent()
                )
            ),
            Program(
                id = 3,
                title = "Jaminan Kemation",
                description = "Manfaat uang tunai yang diberikan kepada ahli waris ketika peserta meninggal dunia bukan akibat kecelakaan kerja atau penyakit akibat kerja.",
                icon = R.drawable.ic_jam_kematian,
                available = true,
                benefit = listOf(
                    """
                        Manfaat JKM dibayarkan kepada ahli waris, apabila peserta meninggal dunia dalam masa aktif terdiri atas:\n
                        1. Santunan kematian sebesar Rp. 20.000.000.00
                        2. Santunan berkala yang dibayarkan sekaligus sebesar 12.000.000.00
                    """.trimIndent()
                ),
                contribution = listOf(
                    "Penerima Upah: 0.30% dari upah sebulan",
                    "Bukan penerima upah :Rp 6.800.00",
                    """
                        Pekerja Jasa Konstruksi terdiri dari: \n
                        a. Pekerja Jasa Konstruksi
                    """.trimIndent()
                )
            ),
            Program(
                id = 4,
                title = "Jaminan Pensiun",
                description = "Jaminan sosial yang bertujuan untuk mempertahankan derajat kehidupan yang layak bagi pserta atau ahli warisnya dengan memberikan penghasilan setelah peserta memasuki usia pensiun, mengalami cacat atau meninggal dunia.",
                icon = R.drawable.ic_jam_pensiun,
                available = true,
                benefit = listOf(
                    "Manfaat Pensiun Hari Tua berupa uang tunia bulanan yang diberikan kepada pserta (yang memenuhi upah minimum 15 tahun yang setara dengan 180 bulan) saat memasuki usia pensiun sampai dengan meninggal dunia",
                    "Menfaat pensiun Janda/Duda berupa uang tunai bulanan yang diberikan kepada janda/duda yang menjadi ahli waris(terdaftar di BPJS Ketenagakerjaan"
                ),
                contribution = listOf(
                    "Besaran Iuran Penerima Upah 1% Pekerja 2% Perusahaan(Dari upah yang dilaporkan"
                )
            ),
            Program(
                id = 5,
                title = "Jaminan Kehilangan Pekerjaan",
                description = "Jaminan yang diberikan kepada pekerja/buruh yang mengalami pemutusan hubungan kerja dengan tujuan mempertahankan derajat kehidupan yang layak pada saat pekerja kehilangan pekerjaan. Pekerja dapat memnuhi kebutuhan dasar hidup yang layak saat terjadi risiko akibat pemutusan hubungan kerja seraya berusaha mendapatkan pekerjaan kembali.",
                icon = R.drawable.ic_jam_kehilangan_pekerjaan,
                available = true,
                benefit = listOf(
                    "Manfaat didapatkan apabila peserta memnuhi masa iur program JKP paling sedikit 12 bulan dalam 24 bulan dan telah membayar iuran paling singkat 6 bulan berturut-turut"
                ),
                contribution = listOf()
            )
        )

        val service: List<Service> = listOf(
            Service(
                id = 1,
                serviceIcon = R.drawable.ic_ser_info,
                serviceName = "Info Program"
            ),
            Service(
                id = 2,
                serviceIcon = R.drawable.ic_ser_autodebit,
                serviceName = "Bayar/Autodebit"
            ),
            Service(
                id = 3,
                serviceIcon = R.drawable.ic_jam_kecelakaan,
                serviceName = "Daftar BPU"
            ),
            Service(
                id = 4,
                serviceIcon = R.drawable.ic_jam_kematian,
                serviceName = "Pengkinian Data"
            ),
            Service(
                id = 5,
                serviceIcon = R.drawable.ic_jam_kecelakaan,
                serviceName = "Kantor Cabang"
            ),
            Service(
                id = 6,
                serviceIcon = R.drawable.ic_jam_hari_tua,
                serviceName = "Mitra Layanan"
            ),
            Service(
                id = 7,
                serviceIcon = R.drawable.ic_ser_pengaduan,
                serviceName = "Pengaduan"
            ),
            Service(
                id = 8,
                serviceIcon = R.drawable.ic_ser_bantuan,
                serviceName = "Bantuan"
            ),
            Service(
                id = 9,
                serviceIcon = R.drawable.ic_ser_more,
                serviceName = "Menu Lainnya"
            ),
        )

    }
}