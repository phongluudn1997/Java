interface ImageCompressor {
    byte[] compress(byte[] imageData);

    static ImageCompressor forData(byte[] imageData) {
        if (imageData.length < 1_000_000) {
            // < 1 MB: Fast, low-overhead compressor
            return new FastLowMemoryCompressor();
        }
        // >= 1 MB: Multi-threaded high-ratio compressor
        return new ParallelHighRatioCompressor();
    }
}

class FastLowMemoryCompressor implements ImageCompressor {

    @Override
    public byte[] compress(byte[] imageData) {
        throw new UnsupportedOperationException("Unimplemented method 'compress'");
    }
}

class ParallelHighRatioCompressor implements ImageCompressor {

    @Override
    public byte[] compress(byte[] imageData) {
        throw new UnsupportedOperationException("Unimplemented method 'compress'");
    }

}