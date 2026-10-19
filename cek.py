
import random
import time
import math
import platform
import os

def insertion_sort(a):
    for i in range(1, len(a)):
        key = a[i]
        j = i - 1
        while j >= 0 and a[j] > key:
            a[j + 1] = a[j]
            j -= 1
        a[j + 1] = key
    return a

def merge_sort(a):
    if len(a) <= 1:
        return a

    tengah = len(a) // 2
    kiri = merge_sort(a[:tengah])
    kanan = merge_sort(a[tengah:])

    hasil = []
    i = j = 0

    while i < len(kiri) and j < len(kanan):
        if kiri[i] <= kanan[j]:
            hasil.append(kiri[i])
            i += 1
        else:
            hasil.append(kanan[j])
            j += 1

    return hasil + kiri[i:] + kanan[j:]

def ukur_waktu(fungsi, n, jenis_data="acak", ulang=5):
    semua_waktu = []

    for _ in range(ulang):
        if jenis_data == "acak":
            data = [random.randint(0, 10**6) for _ in range(n)]
        elif jenis_data == "terurut":
            data = list(range(n))
        else:
            data = list(range(n, 0, -1))

        mulai = time.perf_counter()
        fungsi(data)
        selesai = time.perf_counter()

        semua_waktu.append(selesai - mulai)

    return min(semua_waktu)

ukuran_data = [1000, 2000, 4000, 8000, 16000]

def tampilkan_hasil(nama, fungsi, jenis_data="acak"):
    print(f"\n{nama} - Data {jenis_data}")
    print(f"{'n':>7} {'Waktu (detik)':>15} "
          f"{'Rasio':>10} {'Waktu/f(n)':>15}")

    hasil = []

    for n in ukuran_data:
        waktu = ukur_waktu(fungsi, n, jenis_data)

        if nama == "Insertion Sort":
            fn = n ** 2
        else:
            fn = n * math.log2(n)

        hasil.append((n, waktu, waktu / fn))

    nilai_awal = hasil[0][2]
    waktu_sebelumnya = None

    for n, waktu, nilai_fn in hasil:
        rasio = (
            "-" if waktu_sebelumnya is None
            else f"{waktu / waktu_sebelumnya:.2f}"
        )
        normalisasi = nilai_fn / nilai_awal

        print(f"{n:>7} {waktu:>15.6f} "
              f"{rasio:>10} {normalisasi:>15.2f}")

        waktu_sebelumnya = waktu

    return hasil

hasil_insertion = tampilkan_hasil(
    "Insertion Sort", insertion_sort
)
hasil_merge = tampilkan_hasil(
    "Merge Sort", merge_sort
)

print("\nINSERTION SORT: PENGARUH JENIS DATA")
for jenis in ["terurut", "terbalik"]:
    print(f"\nData {jenis}")
    waktu_4000 = ukur_waktu(
        insertion_sort, 4000, jenis
    )
    waktu_8000 = ukur_waktu(
        insertion_sort, 8000, jenis
    )
    rasio = waktu_8000 / waktu_4000

    print(f"n = 4000 : {waktu_4000:.6f} detik")
    print(f"n = 8000 : {waktu_8000:.6f} detik")
    print(f"Rasio    : {rasio:.2f}")

print("\nSPESIFIKASI KOMPUTER")
print("Sistem operasi:", platform.platform())
print("Prosesor:", platform.processor() or "Tidak tersedia")
print("Versi Python:", platform.python_version())

try:
    import psutil
    print("RAM total:", round(
        psutil.virtual_memory().total / (1024**3), 2
    ), "GB")
except ImportError:
    print("RAM: periksa melalui informasi runtime Colab")
